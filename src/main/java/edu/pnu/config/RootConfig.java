package edu.pnu.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RootConfig {
    @Bean
    public ModelMapper getMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                   .setFieldMatchingEnabled(true)
                   .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                   .setMatchingStrategy(MatchingStrategies.LOOSE);

        return modelMapper;
    }
}
// 5.modelmapper라이브러리, 설정파일 작성