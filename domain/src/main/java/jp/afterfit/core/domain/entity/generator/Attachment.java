package jp.afterfit.core.domain.entity.generator;

import java.io.Serializable;
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
public class Attachment implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.attachment.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.attachment.request_id
     *
     * @mbg.generated
     */
    private Integer requestId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.attachment.table_id
     *
     * @mbg.generated
     */
    private String tableId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.attachment.attach_file
     *
     * @mbg.generated
     */
    private byte[] attachFile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.attachment
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;
}