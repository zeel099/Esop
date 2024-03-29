package com.esop.Esop_management.payload;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@NoArgsConstructor
@Getter
@Setter
public class NotificationDto {
    private int nid;
    private String notification;

    private String time;
    private CompanyDto company;

}
