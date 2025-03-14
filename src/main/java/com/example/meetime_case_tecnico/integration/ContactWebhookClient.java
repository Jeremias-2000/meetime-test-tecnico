package com.example.meetime_case_tecnico.integration;

import com.example.meetime_case_tecnico.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "contact-webhook",url = "${auth.contact.url}",configuration = FeignConfig.class)
public interface ContactWebhookClient {
    @GetMapping("/v3/{appId}/subscriptions")
    String readEventSubscription(@PathVariable("appId") Integer appId,
                                 @RequestParam("hapikey") String hobsputApiKey);


//    curl --request POST \
//            --url 'https://api.hubapi.com/webhooks/v3/0/subscriptions/batch/update?hapikey=YOUR_HUBSPOT_DEVELOPER_API_KEY' \
//            --header 'content-type: application/json' \
//            --data '{
//            "inputs": [
//    {
//        "active": true,
//            "id": 0
//    }
//  ]
//}'
//    {
//        "completedAt": "2025-03-14T09:02:17.813Z",
//            "requestedAt": "2025-03-14T09:02:17.813Z",
//            "startedAt": "2025-03-14T09:02:17.813Z",
//            "links": {
//        "additionalProp1": "string",
//                "additionalProp2": "string",
//                "additionalProp3": "string"
//    },
//        "results": [
//        {
//            "createdAt": "2025-03-14T09:02:17.813Z",
//                "objectTypeId": "string",
//                "propertyName": "string",
//                "active": true,
//                "eventType": "contact.propertyChange",
//                "id": "string",
//                "updatedAt": "2025-03-14T09:02:17.813Z"
//        }
//  ],
//        "status": "PENDING"
//    }
}
