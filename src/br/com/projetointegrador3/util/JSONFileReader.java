package br.com.projetointegrador3.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import br.com.projetointegrador3.model.ListaDeMusica;
import br.com.projetointegrador3.model.Musica;
import br.com.projetointegrador3.model.Playlist;

public class JSONFileReader {
	
	public static ArrayList<Musica> loadMusicas(String arquivo) {
		
		ArrayList<Musica> listaMusicas = new ArrayList<Musica>();
		
		JSONParser jsonParser = new JSONParser();
		
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(
						Thread.currentThread().getContextClassLoader().getResourceAsStream(arquivo)
				)
			)) {
			
			Object obj = jsonParser.parse(reader);
			
			JSONArray musicsJSON = (JSONArray) obj;
			
			for (Object music : musicsJSON) {
				
				JSONObject musicJson = (JSONObject) music;
				
				String nome = (String) musicJson.get("nome");
				String cantor = (String) musicJson.get("cantor");
				String banda = (String) musicJson.get("banda");
				String album = (String) musicJson.get("album");
				String genero = (String) musicJson.get("genero");
				String ano = (String) musicJson.get("ano");
				
				Musica m = new Musica(nome, cantor, banda, album, genero, Integer.parseInt(ano));

				listaMusicas.add(m);
			}
			
			return listaMusicas;
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return listaMusicas;
	}

	public static ArrayList<Playlist> loadPlaylists(String arquivo) {
		
		ArrayList<Playlist> listaPlaylists = new ArrayList<Playlist>();

		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(
						Thread.currentThread().getContextClassLoader().getResourceAsStream(arquivo)
				)
			)) {
			
			Object obj = new JSONParser().parse(reader);
			
			JSONArray ja = (JSONArray) obj;
			
			for (Object playlist : ja) {
				
				ListaDeMusica listaMusicas = new ListaDeMusica();
				
				JSONObject jsonPlaylist = (JSONObject) playlist;
				
				String nomePlaylist = (String) jsonPlaylist.get("playlist");
				
				JSONArray musicas = (JSONArray) jsonPlaylist.get("musicas");

				for (Object musica : musicas) {

					JSONObject jsonMusica = (JSONObject) musica;
					
					String nome = (String) jsonMusica.get("nome");	
					String cantor = (String) jsonMusica.get("cantor");
					String banda = (String) jsonMusica.get("banda");
					String album = (String) jsonMusica.get("album");
					String genero = (String) jsonMusica.get("genero");
					String ano = (String) jsonMusica.get("ano");

					Musica m = new Musica(nome, cantor, banda, album, genero, Integer.parseInt(ano));
					listaMusicas.incluirNoFim(m);
				}
				
				Playlist p = new Playlist(nomePlaylist, listaMusicas);
				listaPlaylists.add(p);

			}
			
			return listaPlaylists;
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return listaPlaylists;

	}

}
