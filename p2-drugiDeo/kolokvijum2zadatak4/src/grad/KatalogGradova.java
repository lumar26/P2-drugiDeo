package grad;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

import grad.exception.GradException;

public class KatalogGradova implements Demografija {

	private List<Grad> gradovi = new LinkedList<Grad>();

	@Override
	public void dodajGrad(Grad grad) {
		int pomIndeks = -1;
		if (!(gradovi.contains(grad))) {
			for (Grad element : gradovi) {
				pomIndeks++;
				if (element.getBrStanovnika() < grad.getBrStanovnika()) {
					gradovi.add(pomIndeks, grad);
					break;
				}
			}
		} else {
			throw new GradException("Grad se vec nalazi u listi");
		}
	}

	@Override
	public void upisiGradoveUKategorije() throws Exception {
		for (Grad grad : gradovi) {
			try {
				if (grad.getBrStanovnika() < 100000) {
					ObjectOutputStream out = new ObjectOutputStream(
							new BufferedOutputStream(new FileOutputStream("mali_gradovi.out")));
					out.writeObject(grad);
					out.close();
					return;
				}
				if (grad.getBrStanovnika() < 1000000) {
					ObjectOutputStream out = new ObjectOutputStream(
							new BufferedOutputStream(new FileOutputStream("srednji_gradovi.out")));
					out.writeObject(grad);
					out.close();
					return;
				}
				ObjectOutputStream out = new ObjectOutputStream(
						new BufferedOutputStream(new FileOutputStream("mali_gradovi.out")));
				out.writeObject(grad);
				out.close();
			} catch (Exception e) {
				throw new GradException(e.getMessage());
			}
		}

	}

}
