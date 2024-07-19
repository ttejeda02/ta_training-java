package com.epam.training.tirzo_tejeda.task3.service;

import com.epam.training.tirzo_tejeda.task3.model.InstanceConfiguration;

/**
 * Utility class to create InstanceConfiguration objects using test data.
 */
public class InstanceConfigurationCreator {

    private static final String TESTDATA_NUMBER_INSTANCES = "testdata.number.instances";
    private static final String TESTDATA_OPERATING_SYSTEM = "testdata.operating.system";
    private static final String TESTDATA_PROVISIONING_MODEL = "testdata.provisioning.model";
    private static final String TESTDATA_MACHINE_FAMILY = "testdata.machine.family";
    private static final String TESTDATA_SERIES = "testdata.series";
    private static final String TESTDATA_MACHINE_TYPE = "testdata.machine.type";
    private static final String TESTDATA_LOCAL_SSD = "testdata.local.ssd";
    private static final String TESTDATA_REGION = "testdata.region";

    /**
     * Creates an InstanceConfiguration object based on test data read from a source.
     * @return InstanceConfiguration object populated with test data.
     */
    public static InstanceConfiguration createInstanceConfiguration() {
        return new InstanceConfiguration(
                TestDataReader.getTestData(TESTDATA_NUMBER_INSTANCES),
                TestDataReader.getTestData(TESTDATA_OPERATING_SYSTEM),
                TestDataReader.getTestData(TESTDATA_PROVISIONING_MODEL),
                TestDataReader.getTestData(TESTDATA_MACHINE_FAMILY),
                TestDataReader.getTestData(TESTDATA_SERIES),
                TestDataReader.getTestData(TESTDATA_MACHINE_TYPE),
                TestDataReader.getTestData(TESTDATA_LOCAL_SSD),
                TestDataReader.getTestData(TESTDATA_REGION)
        );
    }
}
