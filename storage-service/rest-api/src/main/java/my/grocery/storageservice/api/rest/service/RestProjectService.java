package my.grocery.storageservice.api.rest.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import my.grocery.storageservice.api.rest.client.StorageServiceBalanceClient;
import my.grocery.storageservice.api.rest.client.StorageServicePositionClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Primary
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RestProjectService {

    StorageServiceBalanceClient balanceClient;
    StorageServicePositionClient positionClient;


}