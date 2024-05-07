package com.algonquin.domain.service.impl;

import com.algonquin.domain.service.BundleService;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.ResourceBundle;

@Service
public class BundleServiceImpl implements BundleService {
    @Override
    public String getName() {
        Locale locale = Locale.getDefault();
        ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);
        return bundle.getString("username");
    }
}
