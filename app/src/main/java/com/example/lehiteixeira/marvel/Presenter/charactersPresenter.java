package com.example.lehiteixeira.marvel.Presenter;

import android.support.annotation.NonNull;

import com.example.lehiteixeira.marvel.Data.DataManager;
import com.example.lehiteixeira.marvel.Data.model.CharacterMarvel;
import com.example.lehiteixeira.marvel.Data.model.DataWrapper;
import com.example.lehiteixeira.marvel.Data.network.RemoteCallback;
import com.example.lehiteixeira.marvel.Presenter.Contract.charactersContract;

import java.util.List;

/**
 * Created by Lehiteixeira on 11/09/17.
 */

public class charactersPresenter implements charactersContract.Presenter{

    private final DataManager mDataManager;
    private final charactersContract.View mView;

    private static final int ITEM_REQUEST_INITIAL_OFFSET = 0;
    private static final int ITEM_REQUEST_LIMIT = 6;


    public charactersPresenter(@NonNull DataManager mDataManager, charactersContract.View mView) {
        this.mDataManager = mDataManager;
        this.mView = mView;
    }

    @Override
    public void start() {
        getCharacters(ITEM_REQUEST_INITIAL_OFFSET, ITEM_REQUEST_LIMIT, null);
    }

    @Override
    public void onInitialListRequested() {
    }

    @Override
    public void onListEndReached(Integer offset, Integer limit, String searchQuery) {
        getCharacters(offset, limit == null ? ITEM_REQUEST_LIMIT : limit, searchQuery);
    }

    @Override
    public void onCharacterSearched(String searchQuery) {
        getCharacters(ITEM_REQUEST_INITIAL_OFFSET, ITEM_REQUEST_LIMIT, searchQuery);
    }

    private void getCharacters(Integer offset, Integer limit, final String searchQuery) {

        mDataManager.getCharactersList(offset, limit, searchQuery,
                new RemoteCallback<DataWrapper<List<CharacterMarvel>>>() {
                    @Override
                    public void onSuccess(DataWrapper<List<CharacterMarvel>> response) {
//                        mView.hideProgress();
                        List<CharacterMarvel> responseResults = response.getData().getResults();
                        if (responseResults.isEmpty()) {
                            mView.showEmpty();
                        }else {
                            mView.showCharacters(responseResults);
                        }



                    }

                    @Override
                    public void onUnauthorized() {
    //                    mView.hideProgress();
    //                    mView.showUnauthorizedError();

                    }

                    @Override
                    public void onFailed(Throwable throwable) {
    //                    mView.hideProgress();
    //                    mView.showError(throwable.getMessage());

                    }
                });
    }

}
