package com.coviam.Service;

import com.coviam.entity.model.ProviderConfig;
import com.coviam.repository.BusinessConfigRepository;
import com.coviam.repository.ProviderConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProviderService {

    @Autowired
    ProviderConfigRepository providerConfigRepository;

    @Autowired
    BusinessConfigRepository businessConfigRepository;

    public ProviderConfig getProviderConfig(Long id) {
        return providerConfigRepository.getOne(id);
    }

    public void createProvider(String providerName,String providerUrl,String providerCallbackUrl,String providerCredentialKey1,String providerCredentialKey2,ProviderConfig.Status providerStatus) {
        ProviderConfig newProviderConfig = new ProviderConfig(providerName,providerUrl,providerCallbackUrl,providerCredentialKey1,providerCredentialKey2,providerStatus);
         providerConfigRepository.save(newProviderConfig);
    }

}
