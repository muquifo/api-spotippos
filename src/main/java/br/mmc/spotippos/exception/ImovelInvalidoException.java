package br.mmc.spotippos.exception;

public class ImovelInvalidoException extends RuntimeException {
	public ImovelInvalidoException() {
        super();
    }
    public ImovelInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }
    public ImovelInvalidoException(String message) {
        super(message);
    }
    public ImovelInvalidoException(Throwable cause) {
        super(cause);
    }
}
