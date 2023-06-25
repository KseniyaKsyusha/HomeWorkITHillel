package ua.en.kosse.oksana.hillel.hw18.one;

public enum TypeProduct {
    BOOK("Book"),
    PERFUME("Perfume");

    private final String type;

    TypeProduct(String type){
        this.type=type;
    }


    @Override
    public String toString(){
        return type;
    }
}
