package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CsvFileTest {
    CsvFile testFile;

    @BeforeEach
    void init() {
        testFile = new CsvFile(User.getFullFileLocation());
    }

    @Test
    @DisplayName("Testing isExist Method")
    void testIsExist() {
        assertTrue(testFile.isExist());
    }

    @Test
    @DisplayName("Testing Read Method")
    void testRead() {
        List<String> Actual = CsvFile.read(User.getFullFileLocation());
        List<String> Expected = new ArrayList<>();
        Expected.add("First_Name,Last_Name,User_Name,Password,User_Type");
        Expected.add("adel,mohamed,maro,ahmed,ADMIN");
        Expected.add("Adel,Mohamed,Ahmed,A,ADMIN");
        assertLinesMatch(Expected, Actual);
    }

}