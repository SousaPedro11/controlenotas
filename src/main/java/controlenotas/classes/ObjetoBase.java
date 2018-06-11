package controlenotas.classes;

import java.util.stream.Stream;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.reflect.FieldUtils;

public class ObjetoBase<T> {

	@Override
	public int hashCode() {

		final HashCodeBuilder builder = new HashCodeBuilder();

		Stream.of(this.getClass().getDeclaredFields())
				.filter(f -> !f.isAnnotationPresent(IgnorarHashcodeEquals.class)
						|| (f.isAnnotationPresent(IgnorarHashcodeEquals.class)
								&& !f.getAnnotation(IgnorarHashcodeEquals.class).desativarHashCode()))
				.map(f -> f.getName()).forEach(nome -> {

					try {
						final Object valor = FieldUtils.readDeclaredField(this, nome, true);
						builder.append(valor);

					} catch (final IllegalAccessException e) {
						e.printStackTrace();
					}
				});

		return builder.toHashCode();
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(final Object obj) {

		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != this.getClass()) {
			return false;
		}

		final T other = (T) obj;
		final EqualsBuilder builder = new EqualsBuilder();

		Stream.of(this.getClass().getDeclaredFields())
				.filter(f -> !f.isAnnotationPresent(IgnorarHashcodeEquals.class)
						|| (f.isAnnotationPresent(IgnorarHashcodeEquals.class)
								&& !f.getAnnotation(IgnorarHashcodeEquals.class).desativarEquals()))
				.map(f -> f.getName()).forEach(nome -> {

					try {
						final Object valor1 = FieldUtils.readDeclaredField(this, nome, true);
						final Object valor2 = FieldUtils.readDeclaredField(other, nome, true);

						builder.append(valor1, valor2);

					} catch (final IllegalAccessException e) {
						e.printStackTrace();
					}
				});

		return builder.isEquals();
	}

	@Override
	public String toString() {

		final StringBuilder builder = new StringBuilder();

		FieldUtils.getFieldsListWithAnnotation(this.getClass(), AtribuirToString.class).forEach(f -> {

			try {
				final Object valor = FieldUtils.readDeclaredField(this, f.getName(), true);

				final AtribuirToString annotation = f.getAnnotation(AtribuirToString.class);
				builder.append(annotation.prefixo()).append(valor).append(annotation.sufixo());

			} catch (final IllegalAccessException e) {
				e.printStackTrace();
			}
		});

		return builder.toString();
	}
}