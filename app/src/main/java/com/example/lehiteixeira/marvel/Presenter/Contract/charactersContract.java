package com.example.lehiteixeira.marvel.Presenter.Contract;

import com.example.lehiteixeira.marvel.BasePresenterContract;
import com.example.lehiteixeira.marvel.BaseViewContract;
import com.example.lehiteixeira.marvel.Data.model.CharacterMarvel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lehiteixeira on 11/09/17.
 */

public interface charactersContract {

    interface View extends BaseViewContract<Presenter> {

        void showCharacters(List<CharacterMarvel> characterList);

        void showSearchedCharacters(List<CharacterMarvel> characterList);

        void showEmpty();

    }

    interface Presenter extends BasePresenterContract {

        void onInitialListRequested();

        void onListEndReached(Integer offset, Integer limit, String searchQuery);

        void onCharacterSearched(String searchQuery);

    }

}
