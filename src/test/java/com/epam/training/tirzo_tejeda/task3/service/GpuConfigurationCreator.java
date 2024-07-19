package com.epam.training.tirzo_tejeda.task3.service;

import com.epam.training.tirzo_tejeda.task3.model.GpuConfiguration;

/**
 * Utility class to create GpuConfiguration objects using test data.
 */
public class GpuConfigurationCreator {

    private static final String TESTDATA_GPU_MODEL = "testdata.gpu.model";
    private static final String TESTDATA_NUMBER_GPUS = "testdata.number.gpus";

    /**
     * Creates a GpuConfiguration object based on test data read from a source.
     * @return GpuConfiguration object populated with test data.
     */
    public static GpuConfiguration createGpuConfiguration() {
        return new GpuConfiguration(
                TestDataReader.getTestData(TESTDATA_GPU_MODEL),
                TestDataReader.getTestData(TESTDATA_NUMBER_GPUS)
        );
    }
}
