package com.aulaverde.aulaverde;

import com.aulaverde.aulaverde.entity.Alert;
import com.aulaverde.aulaverde.repository.AlertRepository;
import com.aulaverde.aulaverde.service.AlertServiceImpl;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AlertServiceImplTests {

    @Mock
    private AlertRepository alertRepository;

    @InjectMocks
    private AlertServiceImpl alertService;
    @Test
    void getAlertByID_existingID_returnsAlert() {

    Alert alert = new Alert();
    alert.setId(1);
    alert.setMessage("Contenedor al 70%");
    when(alertRepository.findById(1)).thenReturn(Optional.of(alert));

    Optional<Alert> result = alertService.getAlertById(1);

    assertFalse(result.isEmpty());
    assertEquals("Contenedor al 70%", result.get().getMessage());
    verify(alertRepository, times(1)).findById(1);
    }

}