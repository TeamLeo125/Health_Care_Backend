package com.spring.childhealthcare.service.impl;

import com.spring.childhealthcare.common.CommonResponse;
import com.spring.childhealthcare.dto.NotificationDTO;
import com.spring.childhealthcare.entity.Notification;
import com.spring.childhealthcare.mapper.NotificationMapper;
import com.spring.childhealthcare.repository.NotificationRepository;
import com.spring.childhealthcare.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;
    @Override
    public CommonResponse getAllNotificationDetails() {
        log.info("NotificationServiceImpl.getAllNotificationDetails method accessed");
        CommonResponse commonResponse = new CommonResponse();
        List<NotificationDTO> notificationDTOList = new ArrayList<>();
        List<Notification> notificationList = notificationRepository.findAll();
        notificationList.forEach(medicine ->  notificationDTOList.add(notificationMapper.domainToDto(medicine)));
        if (notificationList.isEmpty()) {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setData(new ArrayList<>());
            commonResponse.setMessage("Notification details list not available!");
            log.warn("Notification details not available. message :{}", commonResponse.getMessage());
            return commonResponse;
        }
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Notification details are fetching success!");
        commonResponse.setData(notificationDTOList);
        log.info("NotificationServiceImpl.getAllNotificationDetails method end");
        return commonResponse;
    }

    @Override
    public CommonResponse getNotificationDetailsByNotificationId(Long notificationId) {
        log.info("NotificationServiceImpl.getNotificationDetailsByNotificationId method accessed");
        NotificationDTO notificationDTO;
        CommonResponse commonResponse = new CommonResponse();
        Optional<Notification> notification = notificationRepository.findById(notificationId);
        if(notification.isPresent()) {
            notificationDTO = notificationMapper.domainToDto(notification.get());
        } else {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setData(new ArrayList<>());
            commonResponse.setMessage("Notification details is not available!");
            log.warn("Notification details not available. message : {} ", commonResponse.getMessage());
            return commonResponse;
        }
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Notification details is fetching success!");
        commonResponse.setData(notificationDTO);
        log.info("NotificationServiceImpl.getNotificationDetailsByNotificationId method end");
        return commonResponse;
    }

    @Override
    public CommonResponse saveNotification(NotificationDTO notificationDTO) {
        log.info("NotificationServiceImpl.saveNotification method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Notification> notification = notificationRepository.findById(notificationDTO.getId());
        if(notification.isPresent()){
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Notification details already exist!");
            commonResponse.setData(notificationMapper.domainToDto(notification.get()));
            log.warn("Notification details not exist. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        Notification notificationSavedDetails = notificationRepository.save(notificationMapper.dtoToDomain(notificationDTO, new Notification()));
        commonResponse.setStatus(HttpStatus.CREATED);
        commonResponse.setMessage("Notification details saved success!");
        commonResponse.setData(notificationMapper.domainToDto(notificationSavedDetails));
        log.info("NotificationServiceImpl.saveNotification method end");
        return commonResponse;
    }

    @Override
    public CommonResponse updateNotification(NotificationDTO notificationDTO) {
        log.info("NotificationServiceImpl.updateNotification method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Notification> notification = notificationRepository.findById(notificationDTO.getId());
        if(notification.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Notification details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("Notification details not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        Notification notificationUpdatedDetails = notificationRepository.save(notificationMapper.dtoToDomain(notificationDTO, notification.get()));
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Notification details is update success!");
        commonResponse.setData(notificationMapper.domainToDto(notificationUpdatedDetails));
        log.info("NotificationServiceImpl.updateNotification method end");
        return commonResponse;
    }

    @Override
    public CommonResponse deleteNotificationDetailsByNotificationId(Long notificationId) {
        log.info("NotificationServiceImpl.deleteNotificationDetailsByNotificationId method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<Notification> notification = notificationRepository.findById(notificationId);
        if(notification.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Delete notification details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("Notification details not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        notificationRepository.deleteById(notificationId);
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Notification details is delete success!");
        commonResponse.setData(new ArrayList<>());
        log.info("NotificationServiceImpl.deleteNotificationDetailsByNotificationId method end");
        return commonResponse;
    }
}
