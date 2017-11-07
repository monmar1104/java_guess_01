
package com.infoshareacademy.assertj.showcase;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class NamesStats {

    private List<String> originNames;
    private Set<String> uniqueNames;
    private Map<String, Integer> namesStats;
    private Date initDate;

    /**
     * constructor
     */
    public NamesStats() {
        originNames = new ArrayList<String>();
        uniqueNames = new HashSet<String>();
        namesStats = new HashMap<String, Integer>();
        initDate = new Date();
    }



    public void addPerson(Person person) {
        originNames.add(person.getName());

        String firstNameLowerCase = person.getName().toLowerCase();
        uniqueNames.add(firstNameLowerCase);
        addToStats(firstNameLowerCase);
    }

    private void addToStats(String firstNameLowerCase) {
        if(!namesStats.containsKey(firstNameLowerCase)) {
            namesStats.put(firstNameLowerCase, 0);
        }
        Integer amount = namesStats.get(firstNameLowerCase);
        namesStats.put(firstNameLowerCase,++amount);
    }


    public String createTextReport() {
        StringBuilder text = new StringBuilder();
                    text.append("RAPORT \n");
                    text.append("OKRES ZBIERANIA DANYCH:")
                    .append(this.initDate.toString()).append("-")
                            .append(new Date().toString()).append("\n");
        for (Map.Entry<String, Integer> stringIntegerEntry : namesStats.entrySet()) {
            text.append(stringIntegerEntry.getKey().toUpperCase() + ":\t\t" + stringIntegerEntry.getValue() + "\n");
        }

        return text.toString();
    }


    public Set<String> getUniqueNames() {
        return uniqueNames;
    }

    public Map<String, Integer> getNamesStats() {
        return namesStats;
    }

    public Date getInitDate() {
        return initDate;
    }
}
