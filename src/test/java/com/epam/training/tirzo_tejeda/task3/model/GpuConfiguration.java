package com.epam.training.tirzo_tejeda.task3.model;

import java.util.Objects;

/**
 * Represents a GPU configuration with model and number of GPUs.
 */
public class GpuConfiguration {

    private String gpuModel;
    private String numberOfGpus;

    /**
     * Constructs a new GPU configuration with the given model and number of GPUs.
     * @param gpuModel     the model of the GPU
     * @param numberOfGpus the number of GPUs in the configuration
     */
    public GpuConfiguration(String gpuModel, String numberOfGpus) {
        this.gpuModel = gpuModel;
        this.numberOfGpus = numberOfGpus;
    }

    /**
     * Retrieves the model of the GPU.
     * @return the model of the GPU
     */
    public String getGpuModel() {
        return gpuModel;
    }

    /**
     * Sets the model of the GPU.
     * @param gpuModel the model of the GPU
     */
    public void setGpuModel(String gpuModel) {
        this.gpuModel = gpuModel;
    }

    /**
     * Retrieves the number of GPUs in the configuration.
     * @return the number of GPUs
     */
    public String getNumberOfGpus() {
        return numberOfGpus;
    }

    /**
     * Sets the number of GPUs in the configuration.
     * @param numberOfGpus the number of GPUs
     */
    public void setNumberOfGpus(String numberOfGpus) {
        this.numberOfGpus = numberOfGpus;
    }

    /**
     * Returns a string representation of the GPU configuration.
     * @return a string representation of the GPU configuration
     */
    @Override
    public String toString() {
        return "GpuConfiguration{" +
                "gpuModel='" + gpuModel + '\'' +
                ", numberOfGpus='" + numberOfGpus + '\'' +
                '}';
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * @param o the reference object with which to compare
     * @return {@code true} if this object is the same as the o argument;
     *         {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GpuConfiguration that = (GpuConfiguration) o;
        return Objects.equals(gpuModel, that.gpuModel) &&
                Objects.equals(numberOfGpus, that.numberOfGpus);
    }

    /**
     * Returns a hash code value for the object.
     * @return a hash code value for this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(gpuModel, numberOfGpus);
    }
}
