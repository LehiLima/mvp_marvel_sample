package com.example.lehiteixeira.marvel.View;

import android.content.Context;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lehiteixeira.marvel.Data.DataManager;
import com.example.lehiteixeira.marvel.Data.model.CharacterMarvel;
import com.example.lehiteixeira.marvel.Presenter.Contract.charactersContract;
import com.example.lehiteixeira.marvel.Presenter.charactersPresenter;
import com.example.lehiteixeira.marvel.R;
import com.example.lehiteixeira.marvel.View.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

public class ItemFragment extends Fragment implements charactersContract.View{

    private charactersPresenter mcharactersPresenter;
    private static ItemFragment sameInstanceFragment;
    private  List<CharacterMarvel> listCharacters = new ArrayList<>();
    public RecyclerView recyclerView;
    private SampleAdapter mSampleAdapter = new SampleAdapter(listCharacters);

    private View mView;
    private SwipeRefreshLayout mSwipeRefreshLayout;



    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    public ItemFragment() {
    }

    public static ItemFragment getInstance() {
        sameInstanceFragment = sameInstanceFragment == null ? new ItemFragment() : sameInstanceFragment;
        return sameInstanceFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listCharacters = new ArrayList<>();
        mcharactersPresenter =  new charactersPresenter(DataManager.getInstance(), this);
        mcharactersPresenter.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_item_list, container, false);

        recyclerView = (RecyclerView) mView.findViewById(R.id.list);
        populateList();
        return mView;
    }

    private void populateList() {
        // Set the adapter
             LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            recyclerView.setHasFixedSize(true);
            recyclerView.setMotionEventSplittingEnabled(false);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(mSampleAdapter);
            recyclerView.addOnScrollListener(setupScrollListener(linearLayoutManager));
    }

    private EndlessRecyclerViewOnScrollListener setupScrollListener(RecyclerView.LayoutManager layoutManager) {
        return new EndlessRecyclerViewOnScrollListener((LinearLayoutManager) layoutManager) {

            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                mcharactersPresenter.onListEndReached(totalItemsCount, null, null);
            }
        };
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(DummyItem item);
    }

    @Override
    public void showCharacters(List<CharacterMarvel> characterList) {
        mSampleAdapter.addItems(characterList);
    }

    @Override
    public void showSearchedCharacters(List<CharacterMarvel> characterList) {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void setPresenter(charactersContract.Presenter presenter) {

    }





}
