public class ProblemC {

    public interface HasWeight {
        float weight();
    }

    public static class BagItem implements HasWeight {
        private float weight;

        public BagItem(float weight) {
            this.weight = weight;
        }

        @Override
        public float weight() {
            return weight;
        }
    }

    public static class Bag implements HasWeight {
        private float selfWeight;
        private java.util.List<BagItem> items = new java.util.ArrayList<>();

        public Bag(float selfWeight) {
            this.selfWeight = selfWeight;
        }

        public void addItem(BagItem item) {
            items.add(item);
        }

        @Override
        public float weight() {
            float totalWeight = selfWeight;
            for (BagItem item : items) {
                totalWeight += item.weight();
            }
            return totalWeight;
        }
    }

    public static class Pet implements HasWeight {
        private String name;
        private float petWeight;
        private float carriageWeight;

        public Pet(String name, float petWeight, float carriageWeight) {
            this.name = name;
            this.petWeight = petWeight;
            this.carriageWeight = carriageWeight;
        }

        @Override
        public float weight() {
            return petWeight + carriageWeight;
        }
    }

    public static class WeightStats<T extends HasWeight> {
        private String prefix;
        private java.util.List<T> items = new java.util.ArrayList<>();
        private float minWeight = Float.MAX_VALUE;
        private float maxWeight = Float.MIN_VALUE;
        private float totalWeight = 0;

        public WeightStats(String prefix) {
            this.prefix = prefix;
        }

        public void addToStat(T item) {
            items.add(item);
            float itemWeight = item.weight();
            totalWeight += itemWeight;
            if (itemWeight < minWeight) minWeight = itemWeight;
            if (itemWeight > maxWeight) maxWeight = itemWeight;
        }

        public void printStat() {
            System.out.println(prefix);
            System.out.println("sum = " + totalWeight + " kg.");
            System.out.println("min = " + minWeight + " kg.");
            System.out.println("max = " + maxWeight + " kg.");
            System.out.println();
        }
    }
}