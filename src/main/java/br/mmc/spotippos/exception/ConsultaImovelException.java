package br.mmc.spotippos.exception;

public class ConsultaImovelException extends RuntimeException {
	public ConsultaImovelException() {
        super();
    }
    public ConsultaImovelException(String message, Throwable cause) {
        super(message, cause);
    }
    public ConsultaImovelException(String message) {
        super(message);
    }
    public ConsultaImovelException(Throwable cause) {
        super(cause);
    }
}
