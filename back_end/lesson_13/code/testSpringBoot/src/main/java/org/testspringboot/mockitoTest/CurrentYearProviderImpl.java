package org.testspringboot.mockitoTest;

import java.time.LocalDate;

public class CurrentYearProviderImpl implements CurrentYearProvider{
    @Override
    public int getYear() {
        return LocalDate.now().getYear();
    }
}
