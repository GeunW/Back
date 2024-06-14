package edu.pnu.dto;

import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long pno;
    private String pname;
    private int price;
    private String pdesc;
    private boolean delFlag;

    @Builder.Default
    private List<MultipartFile> files = new ArrayList<>();
    
    @Builder.Default
    private List<String> uploadFileNames = new ArrayList<>();
}
// 2.1. 상품dto