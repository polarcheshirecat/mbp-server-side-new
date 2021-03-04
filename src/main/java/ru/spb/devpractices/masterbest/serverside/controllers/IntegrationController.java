package ru.spb.devpractices.masterbest.serverside.controllers;import org.springframework.http.MediaType;import org.springframework.http.ResponseEntity;import org.springframework.web.bind.annotation.*;import ru.spb.devpractices.masterbest.serverside.dto.IntegrationPushOrderDTO;import ru.spb.devpractices.masterbest.serverside.dto.integration.IntegrationPushDTO;import ru.spb.devpractices.masterbest.serverside.services.IntegrationPushOrderService;@RestController@RequestMapping("/integration")public class IntegrationController {    private final IntegrationPushOrderService pushOrderService;    public IntegrationController(IntegrationPushOrderService pushOrderService) {        this.pushOrderService = pushOrderService;    }    @RequestMapping(value = "/pushOrder",            method = RequestMethod.POST,            produces = MediaType.APPLICATION_JSON_VALUE)    public ResponseEntity<?> pushOrder(@RequestBody IntegrationPushDTO pushDTO){       return pushOrderService.proceedPush(pushDTO);    }}