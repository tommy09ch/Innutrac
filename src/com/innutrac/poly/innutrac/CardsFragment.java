package com.innutrac.poly.innutrac;

/*
 * ******************************************************************************
 *   Copyright (c) 2013 Gabriele Mariotti.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *  *****************************************************************************
 */


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.view.CardListView;

public class CardsFragment extends Fragment {

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cards, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initCard();
    }

    private void initCard() {
        //Initialization an array of Cards
        ArrayList<Card> cards = new ArrayList<Card>();
        for (int i = 0; i < 10; i++) {
            Card card = new Card(getActivity());
            CardHeader header = new CardHeader(getActivity());
            card.setTitle("Card Number " + (i+1));
            card.addCardHeader(header);
            card.setShadow(true);
            cards.add(card);
        }

        CardArrayAdapter mCardArrayAdapter = new CardArrayAdapter(getActivity(), cards);

        CardListView listView = (CardListView) getActivity().findViewById(R.id.myList);
        if (listView != null) {
            listView.setAdapter(mCardArrayAdapter);
        }

    }

}