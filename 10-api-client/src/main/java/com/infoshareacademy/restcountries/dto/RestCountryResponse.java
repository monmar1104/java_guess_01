package com.infoshareacademy.restcountries.dto;

import java.util.List;

public class RestCountryResponse {

        private String name;
        private String capital;
        private List<String> borders;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCapital() {
            return capital;
        }

        public void setCapital(String capital) {
            this.capital = capital;
        }

        public List<String> getBorders() {
            return borders;
        }

        public void setBorders(List<String> borders) {
            this.borders = borders;
        }
    }

