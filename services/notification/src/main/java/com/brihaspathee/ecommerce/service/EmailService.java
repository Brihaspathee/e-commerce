package com.brihaspathee.ecommerce.service;

import com.brihaspathee.ecommerce.constants.EmailTemplates;
import com.brihaspathee.ecommerce.domain.entity.Product;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 06, December 2024
 * Time: 2:10 PM
 * Project: e-commerce
 * Package Name: com.brihaspathee.ecommerce.service
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    private final SpringTemplateEngine templateEngine;

    @Async
    public void sendPaymentSuccessEmail(String destEmail,
                                        String customerName,
                                        BigDecimal amount,
                                        String orderReference)
            throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                UTF_8.name());
        mimeMessageHelper.setFrom("contact@brihaspathee.com");
        final String templateName = EmailTemplates.PAYMENT_CONFIRMATION.getTemplate();
        Map<String, Object> model = new HashMap<>();
        model.put("customerName", customerName);
        model.put("amount", amount);
        model.put("orderReference", orderReference);
        Context context = new Context();
        context.setVariables(model);
        mimeMessageHelper.setSubject(EmailTemplates.PAYMENT_CONFIRMATION.getSubject());
        try{
            String html = templateEngine.process(templateName, context);
            mimeMessageHelper.setText(html, true);
            mimeMessageHelper.setTo(destEmail);
            mailSender.send(mimeMessage);
            log.info("Email sent");
        }catch (MessagingException e){
            log.warn("Warning - cannot send email");
        }
    }

    @Async
    public void sendOrderConfirmationEmail(String destEmail,
                                           String customerName,
                                           BigDecimal amount,
                                           String orderReference,
                                           List<Product> products)
            throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                UTF_8.name());
        mimeMessageHelper.setFrom("contact@brihaspathee.com");
        final String templateName = EmailTemplates.ORDER_CONFIRMATION.getTemplate();
        Map<String, Object> model = new HashMap<>();
        model.put("customerName", customerName);
        model.put("totalAmount", amount);
        model.put("orderReference", orderReference);
        model.put("products", products);
        Context context = new Context();
        context.setVariables(model);
        mimeMessageHelper.setSubject(EmailTemplates.ORDER_CONFIRMATION.getSubject());
        try{
            String html = templateEngine.process(templateName, context);
            mimeMessageHelper.setText(html, true);
            mimeMessageHelper.setTo(destEmail);
            mailSender.send(mimeMessage);
            log.info("Email sent");
        }catch (MessagingException e){
            log.warn("Warning - cannot send email");
        }
    }
}
