package jp.afterfit.core.oauth2.config;

import lombok.Data;
import org.springframework.core.NamedInheritableThreadLocal;
import org.springframework.core.NamedThreadLocal;

@Data
public class MetadataContextHolder {
    private static final ThreadLocal<Metadata> metadataHolder =
            new NamedThreadLocal<Metadata>("Metadata Context");

    private static final ThreadLocal<Metadata> inheritableMetadataHolder =
            new NamedInheritableThreadLocal<Metadata>("Metadata Context");

    /**
     * Reset the metadata for the current thread.
     */
    public static void resetMetadata() {
        metadataHolder.remove();
        inheritableMetadataHolder.remove();
    }

    /**
     * Bind the given Metadata to the current thread,
     * <i>not</i> exposing it as inheritable for child threads.
     *
     * @param metadata the Metadata to expose
     * @see #setMetadata(Metadata, boolean)
     */
    public static void setMetadata(Metadata metadata) {
        setMetadata(metadata, true);
    }

    /**
     * Bind the given Metadata to the current thread.
     *
     * @param metadata    the Metadata to expose,
     *                    or {@code null} to reset the thread-bound context
     * @param inheritable whether to expose the Metadata as inheritable
     *                    for child threads (using an {@link InheritableThreadLocal})
     */
    public static void setMetadata(Metadata metadata, boolean inheritable) {
        if (metadata == null) {
            resetMetadata();
        } else {
            if (inheritable) {
                inheritableMetadataHolder.set(metadata);
                metadataHolder.remove();
            } else {
                metadataHolder.set(metadata);
                inheritableMetadataHolder.remove();
            }
        }
    }

    /**
     * Return the Metadata currently bound to the thread.
     *
     * @return the Metadata currently bound to the thread,
     * or {@code null} if none bound
     */
    public static Metadata getMetadata() {
        Metadata metadata = metadataHolder.get();
        if (metadata == null) {
            metadata = inheritableMetadataHolder.get();
            if (metadata == null) {
                return new Metadata();
            }
        }
        return metadata;
    }
}
