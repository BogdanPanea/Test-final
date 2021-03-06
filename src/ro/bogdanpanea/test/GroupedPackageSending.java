package ro.bogdanpanea.test;

import java.util.ArrayList;
import java.util.List;

public class GroupedPackageSending {

    private List<DataAboutGroupedPackage> dataAboutGroupedPackages;
    private List<Thread> threads = new ArrayList<>();

    public GroupedPackageSending(List<DataAboutGroupedPackage> dataAboutGroupedPackages) {
        this.dataAboutGroupedPackages = dataAboutGroupedPackages;
    }

    public List<Thread> getThreads() {
        return threads;
    }

    public void sendPackage() {

        for (DataAboutGroupedPackage p : dataAboutGroupedPackages) {

            Truck truck = new Truck(p);
            Thread t1 = new Thread(truck);
            threads.add(t1);

            t1.start();

            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
