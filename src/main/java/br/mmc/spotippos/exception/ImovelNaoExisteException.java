package br.mmc.spotippos.exception;

public class ImovelNaoExisteException extends RuntimeException {
	public ImovelNaoExisteException() {
        super();
    }
    public ImovelNaoExisteException(String message, Throwable cause) {
        super(message, cause);
    }
    public ImovelNaoExisteException(String message) {
        super(message);
    }
    public ImovelNaoExisteException(Throwable cause) {
        super(cause);
    }
}
