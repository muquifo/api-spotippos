package br.mmc.spotippos.exception;

public class ImovelExisteException extends RuntimeException {
	public ImovelExisteException() {
        super();
    }
    public ImovelExisteException(String message, Throwable cause) {
        super(message, cause);
    }
    public ImovelExisteException(String message) {
        super(message);
    }
    public ImovelExisteException(Throwable cause) {
        super(cause);
    }
}
