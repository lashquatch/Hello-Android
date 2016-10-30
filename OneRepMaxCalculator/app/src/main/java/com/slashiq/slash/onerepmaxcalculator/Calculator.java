package com.slashiq.slash.onerepmaxcalculator;

/**
 * Created by SLash on 10/2/2016.
 * http://www.weightrainer.net/training/coefficients.html
 */

public class Calculator {

    Integer mWeight;
    Integer mReps;
    String mError;
    Long mOneRepMax;



    //Enum eAlgorithm {BRZYCKI, EPLEY, LANDER, NSCA };


    public Calculator(Integer mWeight, Integer mReps) {
        this.mWeight = mWeight;
        this.mReps = mReps;
    }

    public Integer getmWeight() {
        return mWeight;
    }

    public Integer getmReps() {
        return mReps;
    }

    public Long Calculate (){

        mOneRepMax = 0L;

        // Brzycki
        //iWeight / (1.0278 - (0.0278 * iReps)

        if ((mWeight != null ) && (mReps != null)){

            if (Validate()) {
                mOneRepMax =  Math.round(mWeight / (1.0278 - (0.0278 * mReps)));
                //} else {

                // mOneRepMax = 0;

            }

        }

        return mOneRepMax;

    }

    public boolean Validate(){

        boolean bIsValid = false;

        if ((mWeight > 0) && (mReps > 0)) if (mWeight > mReps) {
            bIsValid = true;
        } else {
            mError = "Weight must be greater than reps.";
        }
        else{
            mError = "Please enter valid data.";
            bIsValid = false;
        }

        return bIsValid;
    }
}
