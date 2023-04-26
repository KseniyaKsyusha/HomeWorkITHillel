package ua.en.kosse.oksana.hillel.hw8.competitions.model;

// 1. Створіть тип даних Учасник та кілька його реалізацій: Людина, Кіт, Робот.
public abstract class Sportsman {
    private String name;
    private String creature;
    private int maxdistance;
    private float maxheight;
    private boolean flag = true;

    public Sportsman(String name, String creature, int maxdistance, float maxheight) {
        this.name = name;
        this.creature = creature;
        this.maxdistance = maxdistance;
        this.maxheight = maxheight;
        //this.flag = true;
    }

    public String getName() {
        return name;
    }

    public String getCreature() {
        return creature;
    }

    public int getMaxdistance() {
        return maxdistance;
    }

    public float getMaxheight() {
        return maxheight;
    }


    public String run(int distance) {
        //flag = true;
        if (getMaxdistance() >= distance) {
            System.out.printf("%s %s пробіг дистанцію %s, макс. дистанция %s )) \n",
                    getName(), getCreature(), distance, getMaxdistance());
        } else {
           System.out.printf("%s %s не пробіг дистанцію %s, нажаль, макс. дистанция %s  (( \n",
                   getName(), getCreature(), distance, getMaxdistance());
            flag = false;
        }
        return "";
    }

    public String jump(float height) {
        if (getMaxheight() >= height && flag) {
            System.out.printf("%s %s перестрибнув стіну %s, макс. висота %s  \n",
                    getName(), getCreature(), height, getMaxheight());
        } else {
            System.out.printf("%s %s не перестрибнув стіну %s, макс. висота %s  \n",
                    getName(), getCreature(), height, getMaxheight());
        }

        return "";
    }
}
