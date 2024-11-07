package com.example.ass1;


public class Recipe {
    private String name;
    private String category;
    private boolean isGlutenFree;
    private boolean isDairyFree;
    private String mealType;

    public Recipe(String name, String category, boolean isGlutenFree, boolean isDairyFree, String mealType) {
        this.name = name;
        this.category = category;
        this.isGlutenFree = isGlutenFree;
        this.isDairyFree = isDairyFree;
        this.mealType = mealType;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public boolean isGlutenFree() { return isGlutenFree; }
    public boolean isDairyFree() { return isDairyFree; }
    public String getMealType() { return mealType; }
}
