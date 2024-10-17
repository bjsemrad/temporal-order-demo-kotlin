{
  inputs = {
    nixpkgs.url = "github:nixos/nixpkgs/nixos-24.05";
  };
  outputs = { self, nixpkgs }:
    let
      system = "x86_64-linux";
      pkgs = import nixpkgs { system = "${system}"; };
      jdk = pkgs.jdk;
      gradle-pkg = (pkgs.callPackage pkgs.gradle-packages.gradle_8 { java = jdk; });
    in
    {
      devShells.${system}.default = pkgs.mkShell {
        buildInputs = [
          jdk
          gradle-pkg
        ];
      };

    };
}
