package com.spring.childhealthcare.service;

import com.spring.childhealthcare.common.CommonResponse;
import com.spring.childhealthcare.dto.NotificationDTO;

public interface NotificationService {
    /**
     * Get all notification
     *
     * @return success or fail response of notification creation
     */
    CommonResponse getAllNotificationDetails();

    /**
     * Get medicine by notification id
     *
     * @param notificationId - required data for get notification by notification id
     * @return success or fail response of get notification by notification id
     */
    CommonResponse getNotificationDetailsByNotificationId(Long notificationId);

    /**
     * Create notification
     *
     * @param notificationDTO - required data for notification save
     * @return success or fail response of notification save
     */
    CommonResponse saveNotification(NotificationDTO notificationDTO);

    /**
     * Update notification
     *
     * @param notificationDTO - required data for notification update
     * @return success or fail response of notification update
     */
    CommonResponse updateNotification(NotificationDTO notificationDTO);

    /**
     * Delete notification by notification id
     *
     * @param notificationId - required data for delete notification by notification id
     * @return success or fail response of delete notification by notification id
     */
    CommonResponse deleteNotificationDetailsByNotificationId(Long notificationId);
}
