package com.elico.viewmodelandlivedata;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;


//Live Data:
public class MyViewModel extends ViewModel
{
    MutableLiveData<Integer> score;

    public LiveData<Integer> getScore()
    {
        if (score == null)
        {
            score = new MutableLiveData<>();
            score.setValue(0); //Is for set the value in the same thread, Post is for setting the value from another thread.
        }
        return score;
    }

    public void incrementScore()
    {
        score.setValue(score.getValue() + 1);
    }

    public void resetScore()
    {
        score.setValue(0);
    }
}
