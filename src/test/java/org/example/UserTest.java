package org.example;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {
    @Test
    void testRegister() throws IOException {
        User.Register("A","A","A","A","ADMIN");
        List<String>actualRows= new ArrayList<>();
        actualRows.add("First_Name,Last_Name,User_Name,Password,User_Type");
        actualRows.add("A,A,A,A,ADMIN");
        BufferedReader test = new BufferedReader(new FileReader(User.FULL_FILE_LOCATION));
        List<String> expectedRows = new ArrayList<>();
        while (true) {
            String rowInfo = test.readLine();
            if (rowInfo == null) {
                break;
            }
            expectedRows.add(rowInfo);
        }
        assertLinesMatch(expectedRows, actualRows);
    }
    @Test
    void testIsDataValid ()
    {
        assertTrue(User.isDataValid("adel"));
    }

}