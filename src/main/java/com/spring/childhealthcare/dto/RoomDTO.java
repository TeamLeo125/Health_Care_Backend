package com.spring.childhealthcare.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RoomDTO {
    private Long id;
    private String roomId;
    private String location;
    private Integer capacity;
    private String roomType;
    private String status;
}
