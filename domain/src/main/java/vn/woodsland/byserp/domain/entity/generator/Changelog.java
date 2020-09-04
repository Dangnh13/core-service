package jp.afterfit.core.domain.entity.generator;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Changelog implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.changelog.id
     *
     * @mbg.generated
     */
    private BigDecimal id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.changelog.applied_at
     *
     * @mbg.generated
     */
    private String appliedAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.changelog.description
     *
     * @mbg.generated
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.changelog
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;
}