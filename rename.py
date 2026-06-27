from pathlib import Path

root = Path(".")

for folder in root.iterdir():
    if folder.is_dir():
        java_files = list(folder.glob("*.java"))

        if not java_files:
            continue

        old_file = java_files[0]

        parts = folder.name.split("-")

        number = parts[0]

        title = "_".join(word.capitalize() for word in parts[1:])

        new_name = f"{number}_{title}.java"

        new_file = folder / new_name

        old_file.rename(new_file)

        print(f"{old_file.name}  -->  {new_name}")

print("\nDone! All Java files renamed.")
