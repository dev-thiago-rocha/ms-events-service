package com.thrtec.events.eventsservice.helper;

import com.thrtec.events.eventsservice.dto.pageable.EventPageRequestDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({MockitoExtension.class})
class PaginationHelperTest {

    @InjectMocks
    private PaginationHelper paginationHelper;

    @Test
    void createPageable_withSuccess() {
        // Arrange
        final var pageRequest = EventPageRequestDto.builder()
                .page(1)
                .size(10)
                .build();
        final Pageable expected = PageRequest.of(pageRequest.getPage(), pageRequest.getSize());

        // Act
        final Pageable actual = paginationHelper.createPageable(pageRequest);

        // Assert
        assertEquals(expected, actual);
    }
}