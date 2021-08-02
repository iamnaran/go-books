package com.kec.gobooks.controller;


// A controller class to handle programming logical operation & api request

import java.lang.ref.WeakReference;

public class CategoryController {


    /*  Suppose that the garbage collector determines at a certain point in time
      that an object is weakly reachable. At that time it will atomically clear all weak references to
      that object and all weak references to any other weakly-reachable objects
      from which that object is reachable through a chain of strong and soft
      references.*/

    private WeakReference<ViewContract> viewContractWeakReference;

    public CategoryController(CategoryController.ViewContract viewContract) {

        this.viewContractWeakReference = new WeakReference<>(viewContract);
    }


    public interface ViewContract {

        void onResponseSuccess();

        void onResponseFail();
    }


    private CategoryController.ViewContract getViewContract() throws NullPointerException{
        if (viewContractWeakReference != null){
            return viewContractWeakReference.get();
        }
        throw new NullPointerException("View is unavailable");

    }

}

