package dev.ia;

import dev.langchain4j.agent.tool.Tool;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class BookingTools {


    @Inject
    BookingService bookingService;


    @Tool("Obtém os detalhes completos de uma reserva com base em seu número de identificação (bookingId).")
    public String getBookingDetails(Long bookingId) {
        return bookingService.getBookingDetails(bookingId)
                .map(Booking::toString)
                .orElse("Reserva com ID " + bookingId + " não encontrada.");
    }


    @Tool("""
        Cancela uma reserva existente.
        Para confirmar o cancelamento, é necessário fornecer o ID da reserva (bookingId).
        O usuário deve estár autenticado
        """)
    public String cancelBooking(long bookingId) {
        return bookingService.cancelBooking(bookingId)
                .map(booking -> "Reserva "+ bookingId + "cancelada com sucesso, Status atual: "+booking.status().toString())
                .orElse("Não foi possivel cancelar a reserva. Verifique se o ID da reserva e se você tem permissão");
    }

    @Tool("Lista os pacotes de viagem disponíveis para uma derterminada categoria (ex: ADVENTURE, TREASURES).")
    public String listPackagesByCategory(Category category) {
        var packages =  bookingService.findPackagesByCategory(category);

        if (packages.isEmpty()) {
            return  "Nenhum pacote de viagem encontrado para a categoria " + category.toString().toLowerCase() + ".";
        }

        return "Pacotes encontrados para a categoria " + category.toString().toLowerCase() + ":" + packages.stream().map(Booking::destination).toList().toString();
    }

}
