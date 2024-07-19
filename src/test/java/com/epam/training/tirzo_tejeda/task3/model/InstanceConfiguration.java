package com.epam.training.tirzo_tejeda.task3.model;

import java.util.Objects;

/**
 * Represents a configuration for an instance with various parameters such as
 * number of instances, operating system, provisioning model, machine family,
 * series, machine type, region, and local SSD.
 */
public class InstanceConfiguration {

    private String numberOfInstances;
    private String operatingSystemSoftware;
    private String provisioningModel;
    private String machineFamily;
    private String series;
    private String machineType;
    private String region;
    private String localSsd;

    /**
     * Constructs a new instance configuration with the specified parameters.
     * @param numberOfInstances       the number of instances
     * @param operatingSystemSoftware the operating system software
     * @param provisioningModel       the provisioning model
     * @param machineFamily           the machine family
     * @param series                  the series
     * @param machineType             the machine type
     * @param localSsd                the local SSD
     * @param region                  the region
     */
    public InstanceConfiguration(String numberOfInstances,
                                 String operatingSystemSoftware,
                                 String provisioningModel,
                                 String machineFamily,
                                 String series,
                                 String machineType,
                                 String localSsd,
                                 String region) {
        this.numberOfInstances = numberOfInstances;
        this.operatingSystemSoftware = operatingSystemSoftware;
        this.provisioningModel = provisioningModel;
        this.machineFamily = machineFamily;
        this.series = series;
        this.machineType = machineType;
        this.localSsd = localSsd;
        this.region = region;
    }

    /**
     * Retrieves the number of instances in the configuration.
     * @return the number of instances
     */
    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    /**
     * Sets the number of instances in the configuration.
     * @param numberOfInstances the number of instances
     */
    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    /**
     * Retrieves the operating system software in the configuration.
     * @return the operating system software
     */
    public String getOperatingSystemSoftware() {
        return operatingSystemSoftware;
    }

    /**
     * Sets the operating system software in the configuration.
     * @param operatingSystemSoftware the operating system software
     */
    public void setOperatingSystemSoftware(String operatingSystemSoftware) {
        this.operatingSystemSoftware = operatingSystemSoftware;
    }

    /**
     * Retrieves the provisioning model in the configuration.
     * @return the provisioning model
     */
    public String getProvisioningModel() {
        return provisioningModel;
    }

    /**
     * Sets the provisioning model in the configuration.
     * @param provisioningModel the provisioning model
     */
    public void setProvisioningModel(String provisioningModel) {
        this.provisioningModel = provisioningModel;
    }

    /**
     * Retrieves the machine family in the configuration.
     * @return the machine family
     */
    public String getMachineFamily() {
        return machineFamily;
    }

    /**
     * Sets the machine family in the configuration.
     * @param machineFamily the machine family
     */
    public void setMachineFamily(String machineFamily) {
        this.machineFamily = machineFamily;
    }

    /**
     * Retrieves the series in the configuration.
     * @return the series
     */
    public String getSeries() {
        return series;
    }

    /**
     * Sets the series in the configuration.
     * @param series the series
     */
    public void setSeries(String series) {
        this.series = series;
    }

    /**
     * Retrieves the machine type in the configuration.
     * @return the machine type
     */
    public String getMachineType() {
        return machineType;
    }

    /**
     * Sets the machine type in the configuration.
     * @param machineType the machine type
     */
    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    /**
     * Retrieves the local SSD in the configuration.
     * @return the local SSD
     */
    public String getLocalSsd() {
        return localSsd;
    }

    /**
     * Sets the local SSD in the configuration.
     * @param localSsd the local SSD
     */
    public void setLocalSsd(String localSsd) {
        this.localSsd = localSsd;
    }

    /**
     * Retrieves the region in the configuration.
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets the region in the configuration.
     * @param region the region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Returns a string representation of the instance configuration.
     * @return a string representation of the instance configuration
     */
    @Override
    public String toString() {
        return "InstanceConfiguration{" +
                "numberOfInstances='" + numberOfInstances + '\'' +
                ", operatingSystemSoftware='" + operatingSystemSoftware + '\'' +
                ", provisioningModel='" + provisioningModel + '\'' +
                ", machineFamily='" + machineFamily + '\'' +
                ", series='" + series + '\'' +
                ", machineType='" + machineType + '\'' +
                ", localSsd='" + localSsd + '\'' +
                ", region='" + region + '\'' +
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
        InstanceConfiguration that = (InstanceConfiguration) o;
        return Objects.equals(numberOfInstances, that.numberOfInstances) &&
                Objects.equals(operatingSystemSoftware, that.operatingSystemSoftware) &&
                Objects.equals(provisioningModel, that.provisioningModel) &&
                Objects.equals(machineFamily, that.machineFamily) &&
                Objects.equals(series, that.series) &&
                Objects.equals(machineType, that.machineType) &&
                Objects.equals(localSsd, that.localSsd) &&
                Objects.equals(region, that.region);
    }

    /**
     * Returns a hash code value for the object.
     * @return a hash code value for this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, operatingSystemSoftware, provisioningModel,
                machineFamily, series, machineType, localSsd, region);
    }
}
