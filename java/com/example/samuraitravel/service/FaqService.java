package com.example.samuraitravel.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.samuraitravel.entity.Faq;
import com.example.samuraitravel.repository.FaqRepository;

@Service
public class FaqService {

    private final FaqRepository faqRepository;

    public FaqService(FaqRepository faqRepository) {
        this.faqRepository = faqRepository;
    }

    // 全FAQ（ページネーション対応）
    public Page<Faq> getAllFaqs(Pageable pageable) {
        return faqRepository.findAll(pageable);
    }

    // 質問文にキーワードが部分一致するFAQ（ページネーション対応）
    public Page<Faq> findAllFaqs(String keyword, Pageable pageable) {
        String likeKeyword = "%" + keyword + "%";
        return faqRepository.findByQuestionLike(likeKeyword, pageable);
    }
}
