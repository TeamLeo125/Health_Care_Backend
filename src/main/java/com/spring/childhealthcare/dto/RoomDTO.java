package com.spring.childhealthcare.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class RoomDTO {
    private Long id;
    private String roomId;
    private String location;
    private Integer capacity;
    private String roomType;
    private String status;
}
