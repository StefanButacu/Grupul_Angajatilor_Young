package pizzashop.service;

import pizzashop.PizzaException;
import pizzashop.model.Payment;
import pizzashop.model.PaymentType;
import pizzashop.repository.PaymentRepository;

import java.util.List;

public class PaymentService {

    private PaymentRepository payRepo;

    public PaymentService(PaymentRepository payRepo) {
        this.payRepo = payRepo;
    }

    public List<Payment> getPayments() {
        return payRepo.getAll();
    }

    public void addPayment(int table, PaymentType type, double amount) {
        Payment payment = new Payment(table, type, amount);
        if (table < 1 || table > 8)
            throw new PizzaException("Table number must be 1-8");
        if (amount <= 0)
            throw new PizzaException("Amount should be positive");
        payRepo.add(payment);
    }

    public double getTotalAmount(PaymentType type) {
        double total = 0.0f;
        List<Payment> l = getPayments();
        if ((l == null) || (l.size() == 0)) return total;
        for (Payment p : l) {
            if (p.getType().equals(type))
                total += p.getAmount();
        }
        return total;
    }
}
