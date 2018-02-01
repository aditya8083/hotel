package com.coviam.util;


import org.springframework.stereotype.Component;

public class GenericErrorType {


        private String errorMessage;

        public GenericErrorType(String errorMessage){
            this.errorMessage = errorMessage;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

}
