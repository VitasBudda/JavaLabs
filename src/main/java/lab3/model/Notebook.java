package lab3.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Notebook implements Comparable<Notebook> {

    @Override
    public int compareTo(Notebook notebook) {
        return name.compareTo(notebook.name);
    }

    public enum OperatingSystem {
        WINDOWS,
        LINUX,
        MAC_OS
    }

    private String name;
    private OperatingSystem operatingSystem;
    private Float weight;
    private Float displayDiagonal;
    private Integer memoryCapacity;
    private Integer ram;
    private Integer price;

    private Notebook() {

    }

    public OperatingSystem getOperatingSystem() {
        return operatingSystem;
    }

    public String getName() {
        return name;
    }

    /**
     *
     * @return weight weight (kg)
     */
    public Float getWeight() {
        return weight;
    }

    /**
     *
     * @return diagonal of display in inches
     */
    public Float getDisplayDiagonal() {
        return displayDiagonal;
    }

    /**
     *
     * @return memory capacity in GigaBytes
     */
    public Integer getMemoryCapacity() {
        return memoryCapacity;
    }

    /**
     *
     * @return ram capacity in MegaBytes
     */
    public Integer getRam() {
        return ram;
    }

    /**
     *
     * @return price in UAH
     */
    public Integer getPrice() {
        return price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notebook notebook = (Notebook) o;
        if (!Objects.equals(name, notebook.name)) return false;
        if (operatingSystem != notebook.operatingSystem) return false;
        if (!Objects.equals(weight, notebook.weight)) return false;
        if (!Objects.equals(displayDiagonal, notebook.displayDiagonal)) return false;
        if (!Objects.equals(memoryCapacity, notebook.memoryCapacity)) return false;
        if (!Objects.equals(ram, notebook.ram)) return false;
        return Objects.equals(price, notebook.price);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (operatingSystem != null ? operatingSystem.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (displayDiagonal != null ? displayDiagonal.hashCode() : 0);
        result = 31 * result + (memoryCapacity != null ? memoryCapacity.hashCode() : 0);
        result = 31 * result + (ram != null ? ram.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "name='" + name + '\'' +
                ", operatingSystem=" + operatingSystem +
                ", weight=" + weight +
                ", displayDiagonal=" + displayDiagonal +
                ", memoryCapacity=" + memoryCapacity +
                ", ram=" + ram +
                ", price=" + price +
                '}';
    }


    /**
     * Use this to build new Notebook
     */
    public static class Builder {

        Notebook notebook;

        public Builder() {
            notebook = new Notebook();
        }

        public Builder setName(String name) {
            notebook.name = name;
            return this;
        }

        public Builder setOperatingSystem(OperatingSystem operatingSystem) {
            notebook.operatingSystem = operatingSystem;
            return this;
        }

        /**
         *
         * @param weight weight (kg)
         * @return instance of this Builder
         */
        public Builder setWeight(Float weight) {
            notebook.weight = weight;
            return this;
        }

        public Builder setDisplayDiagonal(Float displayDiagonal) {
            notebook.displayDiagonal = displayDiagonal;
            return this;
        }

        /**
         *
         * @param memoryCapacity capacity in GigaBytes
         * @return instance of this Builder
         */
        public Builder setMemoryCapacity(Integer memoryCapacity) {
            notebook.memoryCapacity = memoryCapacity;
            return this;
        }

        /**
         * @param ram capacity in MegaBytes
         * @return instance of this Builder
         */
        public Builder setRam(Integer ram) {
            notebook.ram = ram;
            return this;
        }

        public Builder setPrice(Integer price) {
            notebook.price = price;
            return this;
        }

        public Notebook build() {

            // Not initialized fields
            Set<String> notInitializedFields = new HashSet<>();

            if (notebook.name == null) notInitializedFields.add("name");
            if (notebook.operatingSystem == null) notInitializedFields.add("operatingSystem");
            if (notebook.weight == null) notInitializedFields.add("weight");
            if (notebook.displayDiagonal == null) notInitializedFields.add("displayDiagonal");
            if (notebook.memoryCapacity == null) notInitializedFields.add("memoryCapacity");
            if (notebook.ram == null) notInitializedFields.add("ram");
            if (notebook.price == null) notInitializedFields.add("price");

            if (notInitializedFields.size() > 0) {
                throw new IllegalStateException("Not initialized fields: " + notInitializedFields.toString());
            }

            // Value <= 0
            Set<String> lessZeroFields = new HashSet<>();

            if (notebook.weight <= 0) lessZeroFields.add("weight");
            if (notebook.displayDiagonal <= 0) lessZeroFields.add("displayDiagonal");
            if (notebook.memoryCapacity <= 0) lessZeroFields.add("memoryCapacity");
            if (notebook.ram <= 0) lessZeroFields.add("ram");
            if (notebook.price <= 0) lessZeroFields.add("price");

            if (lessZeroFields.size() > 0) {
                throw new IllegalStateException("Fields must be greater than zero: " + lessZeroFields.toString());
            }

            return notebook;
        }

    }

}
