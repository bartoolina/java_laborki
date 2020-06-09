package com.company.devices;

import com.company.Application;
import com.company.Human;
import com.company.salleable;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Phone extends Device implements salleable {
    public static final String DEFAULT_URL = "www.apps.com";
    public static final String DEFAULT_PROTOCOL = "https";
    public static final String DEFAULT_VERSION = "PL";

    public List<Application> apps;

    public Phone(String producer, String model, int yearOfProduction) {
        super(producer, model, yearOfProduction);
        apps = new ArrayList<Application>();
    }

    public boolean isAppInstall(Application app) {
        return apps.contains(app);
    }

    public boolean isAppInstall(String name) {
        for (Application app : apps) {
            if (app.name.equals(name)) return true;
        }
        return false;
    }

    public List<Application> getAllFreeApp() {
        List<Application> freeApps = new ArrayList<Application>();
        for (Application app : apps) {
            if (app.cost == 0.0) freeApps.add(app);
        }
        return freeApps;
    }

    public Double getValueAllApp() {
        Double allValue = 0.0;
        for (Application app : apps) {
            allValue += app.cost;
        }
        return allValue;
    }

    public List<Application> getAppsSortedByName() {
        List<Application> sortedList = new ArrayList<Application>(apps);

        Collections.sort(sortedList, new Comparator<Application>() {
            @Override
            public int compare(Application app1, Application app2) {
                return app1.name.compareTo(app2.name);
            }
        });
        return sortedList;
    }

    public List<Application> getAppsSortedByValue() {
        List<Application> sortedList = new ArrayList<Application>(apps);

        Collections.sort(sortedList, new Comparator<Application>() {
            @Override
            public int compare(Application app1, Application app2) {
                return app1.cost.compareTo(app2.cost);
            }
        });
        return sortedList;
    }

    public void installNewApp(Application app, Human owner) {
        if (owner.cash > app.cost && !isAppInstall(app)) {
            owner.cash -= app.cost;
            this.apps.add(app);
            System.out.println(app.name + " has been installed.");
        }
    }

    public void installAnnApp(String name) {
        System.out.println("Installing " + name + " from default server.");
    }

    public void installAnnApp(String name, String version) {
        System.out.println("Installing " + name + " form default server. Version " + version);
    }

    public void installAnnApp(List<String> names) {
        for (String app : names) {
            System.out.println("Installing " + app + " from default server.");
        }
    }

    public void installAnnApp(URL address) {
        String host = address.getHost();
        String protocol = address.getProtocol();
        String app = address.getPath();
        String version = address.getQuery();

        System.out.println("installing " + app + " in " + version + " version from " + host + " using " + protocol + " protocol.");
    }

    @Override
    public void turnOn() {
        System.out.println("The phone is on now.");
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        Phone phoneSell = seller.phone;
        if (phoneSell != null && phoneSell.equals(this)) {
            if (buyer.cash >= price) {
                System.out.println(buyer + "bought a " + this + " from " + seller);
                buyer.phone = this;
                buyer.cash -= price;
                seller.phone = null;
                seller.cash += price;
            } else {
                System.out.println(buyer + " doesn't have enough money.");
            }
        } else {
            System.out.println(seller + " can't sell not his phone.");
        }
    }
}
