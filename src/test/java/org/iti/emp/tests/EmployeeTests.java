package org.iti.emp.tests;

import org.iti.mobile.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeTests {

    @Mock
    private Employee emp;

    @Test
    void testSalaryGreaterThan1000() {
        // Stups
        when(emp.getSalary()).thenReturn(10000.0);
        when(emp.getId()).thenReturn(1L).thenReturn(10L);
        when(emp.getSalaryForEmployee(1)).thenReturn(8000.0);

        assertTrue(emp.getSalary() >= 2000);
        System.out.println(emp.getId());
        System.out.println(emp.getId());
        assertEquals(8000.0, emp.getSalaryForEmployee(1));

        // spy
        verify(emp,times(2)).getId();
        verify(emp,atLeastOnce()).getSalaryForEmployee(1);

    }

}
